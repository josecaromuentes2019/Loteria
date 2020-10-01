package manejoarchivos;

import com.sun.javafx.geom.Vec2d;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static manejoarchivos.Vista4.TablaDuplos;

public class Archivo {

    public void crearArchivo(String nombreArchivo, String informacion) {
        File archivo;
        FileWriter escribir;
        PrintWriter linea;
        
        String registro;
        String ruta = nombreArchivo;

        archivo = new File(ruta);

        if (!archivo.exists()) {
            try {

                archivo.createNewFile();

                escribir = new FileWriter(archivo, true);
                linea = new PrintWriter(escribir);
                linea.println(informacion);
                linea.close();
                escribir.close();

                JOptionPane.showMessageDialog(null, "Archivo Creado Con Exito", "Informacion", 3);

            } catch (IOException ex) {

                JOptionPane.showMessageDialog(null, "Error Al Crear Archivo", "Informacion", 3);

            }

        } else {
            try {
                escribir = new FileWriter(archivo, true);
                linea = new PrintWriter(escribir);
                linea.println(informacion);
                linea.close();
                escribir.close();

                JOptionPane.showMessageDialog(null, "Informacion\nAlamacenada Con Exito", "Informacion", 3);
            } catch (IOException ex) {

                JOptionPane.showMessageDialog(null, "No Se Pudo Almacenar\nInformacion ", "Informacion", 3);

            }

        }

    }

    public int NumeroRegistros(String ruta) {

        File archivo;
        FileReader lee;
        BufferedReader almacena;
        int numFilas = 0;

        String cadena;

        archivo = new File(ruta);

        try {
            lee = new FileReader(archivo);
            almacena = new BufferedReader(lee);
            cadena = "";

            while (cadena != null) {
                try {
                    cadena = almacena.readLine();

                    if (cadena != null) {

                        numFilas++;
                        
                    }

                } catch (IOException ex) {
                    Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
                    
                }
            }

        } catch (FileNotFoundException ex) {
            
            JOptionPane.showMessageDialog(null, "El archivo no Existe");
        }

        return numFilas;
    }

    public String[][] estudioPractico(String ruta, int va, int va2) {

        int newva;
        int numLineas = NumeroRegistros(ruta);
        int linPractica = numLineas - va2;
        newva = numLineas - va;
        String matriz[][] = new String[numLineas][5];
        String matriz1[][] = new String[va][5];
        File archivo;
        FileReader lee;
        BufferedReader almacena;
        int cont, i, j;

        String cadena;

        archivo = new File(ruta);

        try {
            lee = new FileReader(archivo);
            almacena = new BufferedReader(lee);
            cadena = "";
            cont = 0;
            while (cadena != null) {
                try {
                    cadena = almacena.readLine();

                    if (cadena != null) {
                        String vector[] = cadena.split(",");

                        for (i = cont; i < matriz.length; i++) {
                            for (j = 0; j < matriz[0].length; j++) {

                                matriz[i][j] = vector[j];

                            }

                        }

                        cont++;

                    }

                } catch (IOException ex) {
                    Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
//        System.out.println("\n");

        for (int e = 0; e < matriz1.length; e++) {
            for (int c = 0; c < matriz1[0].length; c++) {
                matriz1[e][c] = matriz[linPractica][c];

            }
            linPractica++;
        }
        
        //________________________________________

//        for (i = 0; i < matriz.length; i++) {
//            for (j = 0; j < matriz[0].length; j++) {
//                System.out.print(matriz[i][j] + "\t");
//
//            }
//
//            System.out.println();
//        }
        matriz = null;
        return matriz1;
    }

    public String[][] leer(String ruta, int va) {
        int newva;
        int numLineas = NumeroRegistros(ruta);
        newva = numLineas - va;
        String matriz[][] = new String[numLineas][5];
        String matriz1[][] = new String[va][5];
        File archivo;
        FileReader lee;
        BufferedReader almacena;
        int cont, i, j;

        String cadena;

        archivo = new File(ruta);

        try {
            lee = new FileReader(archivo);
            almacena = new BufferedReader(lee);
            cadena = "";
            cont = 0;
            while (cadena != null) {
                try {
                    cadena = almacena.readLine();

                    if (cadena != null) {
                        String vector[] = cadena.split(",");

                        for (i = cont; i < matriz.length; i++) {
                            for (j = 0; j < matriz[0].length; j++) {

                                matriz[i][j] = vector[j];

                            }

                        }

                        cont++;

                    }

                } catch (IOException ex) {
                    Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
//        System.out.println("\n");

        for (int e = 0; e < matriz1.length; e++) {
            for (int c = 0; c < matriz1[0].length; c++) {
                matriz1[e][c] = matriz[newva][c];

            }
            newva++;
        }
//___________________________________
//        for (i = 0; i < matriz.length; i++) {
//            for (j = 0; j < matriz[0].length; j++) {
//                System.out.print(matriz[i][j] + "\t");
//
//            }
//
//            System.out.println();
//        }
        matriz = null;
        return matriz1;
    }

    public void generarNumero(String[][] matriz, int l) {

        String matriz1[][] = llenartabla(matriz);
        int valor = l;
        int num;
        int pos = 0;
        int columna1 = 0;
        int columna2 = 0;
        int columna3 = 0;
        int columna4 = 0;
        int a;
        int col1 = -1;
        int col2 = -1;
        int col3 = -1;
        int col4 = -1;
        String vec[] = new String[4];
        String vec1[] = new String[4];

        for (int i = 1; i < matriz1[0].length; i++) {
            num = 0;
            for (int j = 0; j < matriz1.length; j++) {

                if ((Integer.parseInt(matriz1[j][i])) >= num) {
                    num = Integer.parseInt(matriz1[j][i]);
                    pos = Integer.parseInt(matriz1[j][0]);

                    if (i == 1) {
                        columna1 = num;
                    }

                    if (i == 2) {
                        columna2 = num;
                    }

                    if (i == 3) {
                        columna3 = num;
                    }

                    if (i == 4) {
                        columna4 = num;
                    }
                }

            }
            vec[i - 1] = Integer.toString(pos);
        }

        for (int i = 1; i < matriz1[0].length; i++) {
            num = 10;
            for (int j = 0; j < matriz1.length; j++) {

                if ((Integer.parseInt(matriz1[j][i])) <= num) {
                    num = Integer.parseInt(matriz1[j][i]);
                    pos = Integer.parseInt(matriz1[j][0]);

                }
            }
            vec1[i - 1] = Integer.toString(pos);
        }

        columna1 = (columna1 / 2);
        columna2 = (columna2 / 2);
        columna3 = (columna3 / 2);
        columna4 = (columna4 / 2);
        a = columna4;

        for (int i = columna1; i >= 0; i--) {
            for (int j = 1; j < 2; j++) {
                for (int k = 0; k < matriz1.length; k++) {
                    if (Integer.parseInt(matriz1[k][j]) == i) {
                        col1 = Integer.parseInt(matriz1[k][0]);
                        break;

                    }
                }
            }
            if (col1 != -1) {
                break;
            }

        }

        for (int i = columna2; i >= 0; i--) {
            for (int j = 2; j < 3; j++) {
                for (int k = 0; k < matriz1.length; k++) {
                    if (Integer.parseInt(matriz1[k][j]) == i) {
                        col2 = Integer.parseInt(matriz1[k][0]);
                        break;

                    }
                }
            }
            if (col2 != -1) {
                break;
            }

        }
        
        for (int i = columna4; i >= a; i++) {
            for (int j = 4; j < 5; j++) {
                for (int k = 0; k < matriz1.length; k++) {
                    if (Integer.parseInt(matriz1[k][j]) == i) {
                        col4 = Integer.parseInt(matriz1[k][0]);

                    }
                }
            }
            if (col4 != -1) {
                break;
            }

        }

        a = columna3;

        for (int i = columna3; i >= a; i++) {
            for (int j = 3; j < 4; j++) {
                for (int k = 0; k < matriz1.length; k++) {
                    if (Integer.parseInt(matriz1[k][j]) == i) {
                        col3 = Integer.parseInt(matriz1[k][0]);

                    }
                }
            }
            if (col3 != -1) {
                break;
            }

        }

        

        if (valor == 1) {
            Vista5.B1.setText(vec[0]);
            Vista5.B2.setText(vec[1]);
            Vista5.B3.setText(vec[2]);
            Vista5.B4.setText(vec[3]);
        } else {
            if (valor == 2) {
                Vista5.B1.setText(vec[0]);
                Vista5.B2.setText(Integer.toString(col2));
                Vista5.B3.setText(vec[2]);
                Vista5.B4.setText(Integer.toString(col4));
            } else {
                if (valor == 3) {
                    Vista5.B1.setText(Integer.toString(col1));
                    Vista5.B2.setText(vec[1]);
                    Vista5.B3.setText(Integer.toString(col3));
                    Vista5.B4.setText(vec[3]);
                } else {
                    if (valor == 4) {
                        Vista5.B1.setText(vec1[0]);
                        Vista5.B2.setText(vec1[1]);
                        Vista5.B3.setText(vec1[2]);
                        Vista5.B4.setText(vec1[3]);
                    }
                }
            }
        }
        
 
        matriz1 = null;
    }

    public void cargar(String[][] mat) {
        DefaultTableModel modelo = (DefaultTableModel) Vista3.Tabla.getModel();
        int filas = mat.length;
        int columnas = mat[0].length;
        modelo.setRowCount(filas);
        modelo.setColumnCount(columnas);

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Vista3.Tabla.getColumnModel().getColumn(0).setPreferredWidth(210);
                Vista3.Tabla.setValueAt(mat[i][j], i, j);
            }
        }

    }

    public void sorteosSinJugar(String[][] matriz) {

        int sum;
        int sinSalir = 0;

        String matr[][] = new String[10][5];
        for (int i = 0; i < 10; i++) {
            matr[i][0] = Integer.toString(i);
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 1; j < matriz[0].length; j++) {
                sum = 0;
                sinSalir = 0;
                for (int k = 0; k < matriz.length; k++) {
                    if (Integer.parseInt(matriz[k][j]) == i) {

                        //sum++;
                        sinSalir = k;

                    }
                }
                if (sinSalir < matriz.length) {
                    for (int c = sinSalir; c < matriz.length; c++) {
                        if (Integer.parseInt(matriz[c][j]) != i) {
                            sum++;
                        }

                    }
                } else {
                    sum = matriz.length;
                }
                matr[i][j] = Integer.toString(sum);
            }
        }

        DefaultTableModel modelo = (DefaultTableModel) Vista4.TablaSinSalir.getModel();
        int filas = 10;
        int columnas = matr[0].length;
        modelo.setRowCount(filas);
        modelo.setColumnCount(columnas);

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Vista4.TablaSinSalir.setValueAt(matr[i][j], i, j);
            }
        }

    }

    public void duplos(String[][] mtz) {
        String matriz[][];
        int filas = 0;

        int tama = 0;
        for (int i = 1; i < mtz[0].length - 1; i++) {

            for (int j = 0; j < mtz.length; j++) {
                if (mtz[j][i].equals(mtz[j][i + 1])) {
                    tama++;
                }
            }

        }

        if (tama > 0) {
            matriz = new String[tama][5];

            for (int i = 1; i < mtz[0].length - 1; i++) {

                for (int j = 0; j < mtz.length; j++) {
                    if (mtz[j][i].equals(mtz[j][i + 1])) {
                        for (int k = 0; k < mtz[0].length; k++) {
                            matriz[filas][k] = mtz[j][k];
                        }
                        filas++;
                      
                    }
                }

            }

            DefaultTableModel modelo = (DefaultTableModel) Vista4.TablaDuplos.getModel();
            int fil = tama;
            int columnas = 5;
            modelo.setRowCount(fil);
            modelo.setColumnCount(columnas);

            for (int i = 0; i < fil; i++) {
                for (int j = 0; j < columnas; j++) {

                    TablaDuplos.getColumnModel().getColumn(0).setPreferredWidth(210);
                    Vista4.TablaDuplos.setValueAt(matriz[i][j], i, j);

                }
            }
            
        }

        if (tama == 0) {

            DefaultTableModel modelo = (DefaultTableModel) Vista4.TablaDuplos.getModel();
            int fil = tama;
            int columnas = 5;
            modelo.setRowCount(fil);
            modelo.setColumnCount(columnas);

            for (int i = 0; i < fil; i++) {
                for (int j = 0; j < columnas; j++) {

                    TablaDuplos.getColumnModel().getColumn(0).setPreferredWidth(200);
                    Vista4.TablaDuplos.setValueAt("", i, j);

                }
            }

        }
    }

    public String[][] llenartabla(String[][] MATR) {

        String tabla[][] = new String[10][5];

        int sum = 0;

        for (int i = 0; i < 10; i++) {
            tabla[i][0] = Integer.toString(i);
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 1; j < MATR[0].length; j++) {
                sum = 0;
                for (int k = 0; k < MATR.length; k++) {
                    if (Integer.parseInt(MATR[k][j]) == i) {
                        sum++;
                    }
                }
                tabla[i][j] = Integer.toString(sum);

            }
        }
//_____________________________________
//        System.out.println("");
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 5; j++) {
//                System.out.print(tabla[i][j] + "\t");
//            }
//            System.out.println();
//        }

        DefaultTableModel modelo = (DefaultTableModel) Vista4.Tabla.getModel();
        int filas = 10;
        int columnas = tabla[0].length;
        modelo.setRowCount(filas);
        modelo.setColumnCount(columnas);

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Vista4.Tabla.setValueAt(tabla[i][j], i, j);
            }
        }
        return tabla;

    }

}
