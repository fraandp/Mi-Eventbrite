
package juegoeventbrite;
import javax.swing.JOptionPane; //Importamos la libreria JOptionPane para los mensajes al usuario
import java.util.concurrent.ThreadLocalRandom; //Importamos la libreria ThreadLocalRandom para seleccionar valores aleatorios

public class JuegoEventbrite {

    public static void main(String[] args) {
        boolean salir =false;
        do{
           String[] options = {"Adivina Computadora", "Adivino Yo"}; //Creamos array con opciones (Adivina Computadora => 0) (Adivino Yo => 1)
           int seleccion = JOptionPane.showOptionDialog(null, 
                   "Que acción desea realizar?", "Juego Adivinar Número - Por Francisco Del Pópolo", 
                   JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                   null, 
                   options, options[0]);  //Mostramos un mensaje donde el usuario puede seleccionar que acción ejecutar (seteamos arreglo con opciones) 

           switch (seleccion){ 
               case 0: //En caso de que la opción elegida sea Adivina Computadora (0)
                   adivinaComputadora(); //Invocamos a la función estática adivinaComputadora() para que la computadora adivine nuestro numero 
                   break;
               case 1:
                   adivinoYo();  //Invocamos a la función estática adivinoYo() para que el usuario adivine el valor seleccionado por la computadora
                   break;
           }

           /* ----- Preguntar al usuario si desea cerral la aplicacion o seguir jugando*/
           String[] optionsSalir = {"Si", "No"}; //Creamos array con opciones
           int seleccionSalir = JOptionPane.showOptionDialog(null, 
                   "Desea cerrar la aplicación?", "Juego Adivinar Número", 
                   JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                   null, 
                   optionsSalir, optionsSalir[0]);

           switch (seleccionSalir){ 
               case 0: 
                   salir = true;
                   break;
               case 1:
                   salir = false;
                   break;
           }

           /* ------------------ */

        }while(!salir); // En caso de que el booleano salir sea true saldremos del bucle asi cerrando la aplicación, caso contrario seguiremos jugando
    }
    
    static void adivinaComputadora(){
        
        int miNumero, // miNumero -> variable que posteriormente tomará un valor aleatorio
                min=1, // min -> Valor minimo a escoger aleatoriamente
                max=100, // max -> Valor máximo a escoger aleatoriamente
                respuesta; //Respuesta del usuario (+,-,=)
        
        JOptionPane.showMessageDialog(null,"Elija un número del 1 al 100 y memorícelo "
                          + "\n .Responda con ' - ' si el numero es menor "
                          + "\n .Responda con ' + ' si el numero es mayor "
                          + "\n .Responda con ' = ' si el numero es correcto ");
        
        do{ 
            
           miNumero= ThreadLocalRandom.current().nextInt(min, max + 1); //Asignamos valor aleatorio a la variable miNumero, este valor se encontrará en un rango entre el minimo y el máximo (por defecto 1 y 100, luego serán modificados)

            String[] options = {" + ", " - ", " = "}; //Creamos array con opciones
            respuesta = JOptionPane.showOptionDialog(null, 
                   " Tu numero es "+miNumero+" ?", "Juego Adivinar Número", 
                   JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                   null, 
                   options, options[0]);  //Mostramos un mensaje donde el usuario puede seleccionar que acción ejecutar (seteamos arreglo con opciones) 
           
            switch (respuesta) {
                case 0:
                    min = miNumero+1; //En caso de que el valor escogido por el usuario sea mayor modificaremos el mínimo del rango a la variable miNumero
                     break;
                case 1:
                    max = miNumero-1; //En caso de que el valor escogido por el usuario sea menor modificaremos el máximo del rango a la variable miNumero
                     break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Gane! Su numero es "+miNumero+"\n\n DESARROLLADO POR FRANCISCO DEL PÓPOLO"); //Mensaje que se muestra al coincidir los valores
                    break;
            }
            
        }while(respuesta != 2); //Saldrá del bucle principal si la respuesta del usuario es =
    }
    
    static void adivinoYo(){
        int 
            respuesta // Valor seleccionado por el usuario
            ,min=1
            ,max=100
            ,miNumero=ThreadLocalRandom.current().nextInt(min, max + 1); //La computadora seleccionara un numero aleatorio entre 1 y 100, el cuál tendrá que ser adivinado por el usuario    
         
        //System.out.println(miNumero); //Mostramos en consola el numero seleccionado por la computadora para demostrar que el valor existe realmente 

        do{
           respuesta = Integer.parseInt(JOptionPane.showInputDialog("Elije un número del 1 al 100:")); //El usuario selecciona un número entre 1 y 100
           
           if(respuesta>miNumero){ //Si el valor escogido por el usuario es mayor al valor de la computadora 
               JOptionPane.showMessageDialog(null, "Mi número es menor"); //Mostramos el siguiente mensaje informando al usuario
           }else if(respuesta<miNumero){
               JOptionPane.showMessageDialog(null, "Mi número es mayor");
           }else{
               JOptionPane.showMessageDialog(null, "Correcto! El número es "+miNumero+"\n\n DESARROLLADO POR FRANCISCO DEL PÓPOLO");
           }
        }while(miNumero != respuesta); //Saldrá del bucle principal solo si el numero del usuario coincide con el numero de la computadora
     }
}

