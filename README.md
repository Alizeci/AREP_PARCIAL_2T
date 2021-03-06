# PARCIAL 2T

Se dise帽a, construye y despliega dos servicios usando el framework de **Spark** y un microcontenedor **Docker** desplegado en una instancia EC2 de **AWS**, capaces de resolver las funciones *arcoseno* y *raiz cuadrada*.

## Entendimiento 馃幆

  馃搷**Tiene 3 endpoints:** 
  + **GET** */hello*, permite obtener un saludo de bienvenida.
  + **GET** */acos*, permite obtener el arcoseno de un numero dado como par谩metro de tipo "Double", retorna el resultado de hacer la operaci贸n en formato JSON.
  + **GET** */sqrt*, permite obtener la raiz cuadrada de un numero dado como par谩metro de tipo "Double", retorna el resultado de hacer la operaci贸n en formato JSON.

## Instrucciones

### Clonando
  
  **Para clonarlo use el siguiente comando de git haciendo referencia al presente repositorio en Github**
  ```sh
    git clone https://github.com/Alizeci/AREP_PARCIAL_2T.git
  ```
    
### Compilando

  **馃搶 Por consola, ubiquese en el directorio del proyecto clonado y ejecute el siguiente bloque de comandos**  
   ```sh
      cd AREP_PARCIAL_2T
      mvn clean install
      mvn exec:java -D "exec.mainClass"="co.edu.escuelaing.calculator.CalculatorApp"
   ```

  **馃搶 Por IDE, abra el proyecto en su IDE favorito y ejecuta la aplicaci贸n de java (Run), la clase** *CalculatorApp.java*
   > Una vez compilado el proyecto podr谩 dirigirse al browser y probar los endpoint http://localhost:4500/acos?value=1 y http://localhost:4500/sqrt?value=16

### Resultado ![resultado](https://img.icons8.com/ios-filled/25/000000/test-results.png)

**Funci贸n Acos**
<!DOCTYPE html>
<html>
    <head></head>
    <body>
      <p float="left">
        <img src="https://github.com/Alizeci/AREP_PARCIAL_2T/blob/main/img/local-acos.png" alt="L0" width="700"/>
      </p>
    </body>
</html>

**Funci贸n Sqrt**
<!DOCTYPE html>
<html>
    <head></head>
    <body>
      <p float="left">
        <img src="https://github.com/Alizeci/AREP_PARCIAL_2T/blob/main/img/local-sqrt.png" alt="L1" width="700"/>
      </p>
    </body>
</html>

### Desplegando

#### ![Docker](https://img.icons8.com/color/38/000000/docker.png) Parte I

1. **Para crear la imagen, ejecute el siguiente comando. Debe estar ubicado en la raiz del proyecto.**
    ```sh
    docker build --tag dockercalculatorapp .
    ```

2. **Verifique que se crearon los servicios, usando el siguiente comando.**
    ```sh
    docker ps
    ```
    > Puede ingresar a la aplicaci贸n de Docker Desktop y revisar que el contenedor e imagen y/o vol煤men(es) fueron creados, est谩n corriendo.

3. **Ahora se sube las imagen del punto 2 a Docker Hub, usando el siguiente bloque de comandos. Previamente, debe haber creado una cuenta y un repositorio para la  imagen.**
    ```sh
    1   docker login    --Realizamos la autenticaci贸n
    2   docker tag dockercalculatorapp alizeci/dockercalculatorapp    --Ejemplo de la imagen cargada con mi cuenta de Docker Hub
    3   docker push alizeci/dockercalculatorapp :latest       --Empujar imagen al repositorio en Docker Hub
    ```
    
### ![AWS](https://img.icons8.com/color/38/000000/amazon-web-services.png) Parte II

1. **Para el despliegue en aws, debemos tener instalada una m谩quina virtual EC2 previamente. Ejecutamos el siguiente bloque de c贸digo para instalar docker y actualizarla.**
    ```sh
    sudo yum update -y
    sudo yum install docker
    ```

2. **Posteriormente, iniciamos el servicio de docker y configuramos nuestro usuario en el grupo de docker, usando los siguientes comandos.**
    ```sh
    sudo service docker start
    sudo usermod -a -G docker ec2-user
    ```
    > Nos desconectamos de la m谩quina virtual e ingresamos nuevamente para que la configuraci贸n de grupos de usuarios tenga efecto, usando `exit`.

3. **Abra los puertos de entrada del security group de la m谩xima virtual para acceder al servicio. Por ejemplo, el puerto 34000 en la plataforma de AWS**
    
4. **Ahora a partir de la imagen creada en Dockerhub cree una instancia de un contenedor docker independiente de la consola (opci贸n 鈥?-d鈥?) y con el puerto 6000 enlazado a un puerto f铆sico de su m谩quina (opci贸n -p).**
    ```sh
    docker run -d -p 34000:6000 --name dockerimageaws alizeci/dockercalculatorapp
    ```

5. **Ahora podremos acceder a los servicios a trav茅s de aws en el navegador con el DNS p煤blico de nuestra m谩quina virtual y el puerto** *34000*. **Por ejemplo,** http://ec2-35-172-134-240.compute-1.amazonaws.com:34000/acos?value=0.45


### Resultado del despliegue ![resultado](https://img.icons8.com/ios-filled/25/000000/test-results.png)

**En funcionamiento**
> Usando **Postman**
<!DOCTYPE html>
<html>
    <head></head>
    <body>
      <p float="left">
        <img src="https://github.com/Alizeci/AREP_PARCIAL_2T/blob/main/img/postman-acos.png" alt="P0" width="400"/>
        <img src="https://github.com/Alizeci/AREP_PARCIAL_2T/blob/main/img/postman-sqrt.png" alt="P1" width="400"/>
      </p>
    </body>
</html>

> Usando el **Browser**
<!DOCTYPE html>
<html>
    <head></head>
    <body>
      <p float="left">
        <img src="https://github.com/Alizeci/AREP_PARCIAL_2T/blob/main/img/browser-acos.png" alt="B0" width="400"/>
        <img src="https://github.com/Alizeci/AREP_PARCIAL_2T/blob/main/img/browser-sqrt.png" alt="B1" width="400"/>
      </p>
    </body>
</html>

## 馃帪锔? Video Funcionamiento
Ver con el siguiente enlace [Video](https://github.com/Alizeci/AREP_PARCIAL_2T/blob/main/videoFuncionamiento.mp4)
  
## Autor ![Autor](https://img.icons8.com/fluency/30/000000/person-female.png)
Laura Alejandra Izquierdo Castro
