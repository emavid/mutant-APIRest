package com.example.mutant.services;

import com.example.mutant.entities.Mutant;
import com.example.mutant.repositories.MutantRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.io.Serializable;


@Service
public class MutantService implements BaseService<Mutant,Long>{

    private MutantRepository mutantRepository;

    public MutantService(MutantRepository mutantRepository){
        this.mutantRepository=mutantRepository;
    }//esto con @Autowired no hace falta

    @Override
    @Transactional
    public Mutant detectarMutante(Mutant entity) throws Exception {
        try {
            //ver como tirar una exception para generar el forbidden
            if(isMutant(entity.getDna())==true){
                entity= mutantRepository.save(entity);
                return entity;
            }else{
                throw new Exception();
            }



        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if (mutantRepository.existsById(id)){
                mutantRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public static boolean isMutant(String[] dna) {

        //comprobamos que el arreglo sea NxN
        if (dna.length != dna[0].length()) {
            System.out.println("el arreglo tiene que ser NxN");
            return false;
        } else {

            String[] dnaMutantes = {"AAAA", "CCCC", "GGGG", "TTTT"};

            //comprobacion horizontal
            System.out.println("----------comprobacion horizontal----------------");
            for (int i = 0; i < dna.length; i++) {
                dna[i].toUpperCase();
                for (String palabra : dnaMutantes) {
                    if (dna[i].contains(palabra)) {
                        System.out.println("este dna es mutante (por metodo horizontal)");
                        return true;
                    }
                }
            }

            //Creacion de una matriz
            char[][] matriz = new char[dna.length][dna.length];
            for (int i = 0; i < dna.length; i++) {
                String temp1 = dna[i].toUpperCase();
                char[] charDna = temp1.toCharArray();
                for (int j = 0; j < dna.length; j++) {
                    if(!(charDna[j]=='A'||charDna[j]=='C'||charDna[j]=='G'||charDna[j]=='T')){
                        System.out.println("el dna recibido recibe caracteres distintos a A,C,G o T");
                        return false;
                    }
                    matriz[i][j] = charDna[j];
                }
            }

            //Comprobacion vertical
            System.out.println("----------comprobacion vertical----------------");
            for (int j = 0; j < matriz.length; j++) {
                String dnaTemp = "";
                for (int i = 0; i < matriz.length; i++) {
                    dnaTemp = dnaTemp + matriz[i][j];
                }
                for (String palabra : dnaMutantes) {
                    if (dnaTemp.contains(palabra)) {
                        System.out.println("este dna es mutante (por metodo vertical)");
                        return true;
                    }
                }
            }

            //Comprobacion Oblicua
            System.out.println("----------comprobacion oblicua----------------");

            //Comprobacion i=j
            String dnaTemp = "";
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz.length; j++) {
                    if (i == j) {
                        dnaTemp = dnaTemp + matriz[i][j];
                    }
                }
            }
            for (String palabra : dnaMutantes) {
                if (dnaTemp.contains(palabra)) {
                    System.out.println("este dna es mutante (por metodo oblicuo)");
                    return true;
                }
            }
            System.out.println("dna j=i: \n" + dnaTemp);

            //Comprobacion j>i
            int jMax = (matriz.length) - 3;//Ya que las ultimas 3 diagonales son mas chicas que los String a comparar
            int jActual = 1;
            while (jActual < jMax) {
                String dnaTemp2 = "";
                for (int i = 0; i < matriz.length; i++) {

                    for (int j = 0; j < matriz.length; j++) {
                        if (i == (j - jActual)) {
                            dnaTemp2 = dnaTemp2 + matriz[i][j];
                        }
                    }

                    System.out.println("dna j=i>1: \n" + dnaTemp2);
                    for (String palabra : dnaMutantes) {
                        if (dnaTemp2.contains(palabra)) {
                            System.out.println("este dna es mutante (por metodo oblicuo)");
                            return true;

                        }
                    }
                }
                jActual++;
            }

            //Comprobacion j<i
            jActual = 1;
            while (jActual < jMax) {
                String dnaTemp3 = "";
                for (int i = 0; i < matriz.length; i++) {

                    for (int j = 0; j < matriz.length; j++) {
                        if (i == (j + jActual)) {
                            dnaTemp3 = dnaTemp3 + matriz[i][j];
                        }
                    }
                    System.out.println("dna j=i<1: \n" + dnaTemp3);
                    for (String palabra : dnaMutantes) {
                        if (dnaTemp3.contains(palabra)) {
                            System.out.println("este dna es mutante (por metodo oblicuo)");
                            return true;
                        }
                    }
                }
                jActual++;
            }
        }
        System.out.println("el dna no es mutante");
        return false;
    }

}
