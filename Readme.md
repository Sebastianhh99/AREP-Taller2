# Taller 2 AREP

>## Autor
>>Sebastian Herrera Hernandez
>>
>>Documentacion en: resouces/apidocs/index.html
>
>## Ejercicio 1
>> La clase usada para el Ejercicio 1 es la URLScanner muestra en consola el protocolo, autoridad, host, puerto, path, query, archivo y ref para ejecutarse debe usarse
>>
>> `mvn exec:java -Dexec.mainClass="co.escuelaing.edu.networking.URLScanner"`
>
>## Ejercicio 2
>> La clase usada para el Ejercicio 2 es la URLReader esta accepta por consola un String de la URL que se va a escanear linea por linea y genera un archivo en ***./static*** llamado resultado.html para ejecutarse debe usarse
>>
>> `mvn exec:java -Dexec.mainClass="co.escuelaing.edu.networking.URLReader"` 
>
>## Ejercicio 3
>> Para este caso se usan dos clases el cliente llamado SquareClient y el servidor llamado SquareServer la informacion se envia desde el cliente y el servidor responde en la consola del cliente los comando para correr son
>>
>> `mvn exec:java -Dexec.mainClass="co.escuelaing.edu.networking.squareservice.SquareServer"`
>>
>> `mvn exec:java -Dexec.mainClass="co.escuelaing.edu.networking.squareservice.SquareClient"`
>
>## Reto 1
>> Para el reto se uso una clase HttpServer que recibe el path de la URL y busca dentro de los archivos estaticos en caso de no encontrar el recurso solicitado se retorna un pagina determinada de 404
>>
>> link: https://taller2arep.herokuapp.com/
>>
>>`mvn exec:java -Dexec.mainClass="co.escuelaing.edu.networking.httpserver.HttpServer"`




