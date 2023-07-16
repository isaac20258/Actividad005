package Metodos;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class ExpenGolosinas {

    // Definimos la matriz
    String Golosinas[][];
    double Precio[][];
    int Cantidad[][];
    int TFila, TColumna;

    ExpenGolosinas() {
        int i, j;
        TFila = Integer.parseInt(JOptionPane.showInputDialog("Numero de filas de la matriz  : "));
        TColumna = Integer.parseInt(JOptionPane.showInputDialog("Numero de columna de la matriz   : "));

        Golosinas = new String[TFila][TColumna];
        Precio = new double[TFila][TColumna];
        Cantidad = new int[TFila][TColumna];

        //Se llena una matriz vacia a partir del recorrido
        //de su filas
        for (i = 0; i < TFila; i++) {
            for (j = 0; j < TColumna; j++) {
                Golosinas[i][j] = "";
                Precio[i][j] = 0;
                Cantidad[i][j] = 0;

            }
        }

    }

    public void setLlenarMatrizGolo() {
        int i;  //indice para las filas
        int j; //indice para las columnas

        String Salida = "  Nombre de las golosina ";

        for (i = 0; i < TFila; i++) {
            Salida += " " + i + ",golosina ";
            for (j = 0; j < TColumna; j++) {
                Salida += " " + j + " : ";
                Golosinas[i][j] = (JOptionPane.showInputDialog(Salida));
                Salida = "Nombre de las golosina " + i + ",golosina : ";
            }
            Salida = " Nombre de las golosina ";
        }
        String Mensa = " Precio de las golosina";
        for (i = 0; i < TFila; i++) {
            Mensa += " " + i + ",golosina ";
            for (j = 0; j < TColumna; j++) {
                Mensa += " " + j + " : ";
                Precio[i][j] = Double.parseDouble(
                        JOptionPane.showInputDialog(Mensa));
                Mensa = " Precio de las golosina " + i + ",golosina : ";
            }
            Mensa = "Precio de las golosina ";

        }
        String Men = " Cantidad de las golosina";
        for (i = 0; i < TFila; i++) {
            Men += " " + i + ",golosina ";
            for (j = 0; j < TColumna; j++) {
                Men += " " + j + " : ";
                Cantidad[i][j] = Integer.parseInt(
                        JOptionPane.showInputDialog(Men));
                Men = " Cantidad de las golosina " + i + ",golosina : ";
            }
            Men = "Cantidad de las golosina";

        }
    }

    //Este metodo actualiza el contenido de la fila
    //de un JTable a partir de su modelo de datos 
    //(JTableModel)
    public void setLlenarJTable(JTable tabl) {
        int i, j; //Este indice recorre los elementos de la matriz
        int indice = 0; //Este indice para ubicar posicion de fila en el JTable
        DefaultTableModel siModelo = new DefaultTableModel();
        for (j = 0; j < TColumna; j++) {
            siModelo.addColumn("Golosina " + j);
        }
        for (i = 0; i < TFila; i++) {
            siModelo.addRow(new Object[TColumna]);
            for (j = 0; j < TColumna; j++) {
                siModelo.setValueAt(Golosinas[i][j], i, 0);
                 siModelo.setValueAt(Precio[i][j], i, 1);
                  siModelo.setValueAt(Cantidad[i][j], i, 2);

            }
            tabl.setModel(siModelo);
        }
    }
}
   
   

