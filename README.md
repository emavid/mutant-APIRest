# mutant-APIRest
API para detectar un mutante mediante un dna


POST http://localhost:9000/api/v1/mutant

### Ejemplo de dna mutante en JSON

`{
    "dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"] 
}`

### Ejemplo de dna NO mutante en JSON

`{
    "dna":["ATGCGA","CAGTGC","TTATTT","AGACGG","GCGTCA","TCACTG"] 
}`

### Proyecto:
En rama master
