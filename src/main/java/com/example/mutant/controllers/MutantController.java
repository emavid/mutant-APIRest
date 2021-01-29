package com.example.mutant.controllers;

import com.example.mutant.entities.Mutant;
import com.example.mutant.services.MutantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/mutant")
public class MutantController {
    private MutantService mutantService;

    public MutantController (MutantService mutantService){
        this.mutantService=mutantService;
    }

    @PostMapping("")
    public ResponseEntity<?> detectarMutante(@RequestBody Mutant entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(mutantService.detectarMutante(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("\"error\": \"" + e.getMessage() + "\"}");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(mutantService.delete(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("\"error\": \"" + e.getMessage() + "\"}");
        }
    }

}
