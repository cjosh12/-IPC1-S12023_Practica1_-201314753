import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Practica1 {
    static int pos = 0, posd = 0, posv = 0;
    static double total, desOb;
    static String prod[][] = new String[20][2];//matriz de productos
    static String desc[][] = new String[20][2];//matriz de descuentos
    static String venta[][] = new String[20][3];
    static String reporte[][] = new String[20][2];

    public static void main(String[] args) {
        String usuario, contra;
        boolean in = false;
        Scanner log = new Scanner(System.in);
        do {//repetira la misma opcion hasta que se ingrese el usuario y contraseña correcto
            System.out.println("ingrese usuario: ");
            usuario = log.nextLine();
            if (usuario.equals("cajero_201314753")) {
                System.out.println("ingrese contraseña:");
                contra = log.nextLine();
                if (contra.equals("ipc1_201314753")) {
                    in = true;
                    Menu();
                } else {
                    System.out.println("contraseña incorrecta");
                }
            } else {
                System.out.println("Usuario Incorrecto");
            }
        } while (!in);
        Menu();
    }

    public static void Menu() {

        String cliente, codD, nit, empresa = "Super-25", caj = "Carlos Calderón";
        Scanner scan = new Scanner(System.in);
        boolean act = true, n = true, c = true;
        int opc, subt = 0;

        Date fecha = new Date();
        try {
            do {
                System.out.println("*******************************" +
                        "\n****Bienvenido a Super-25******" +
                        "\n****1. Agregar Productos *******" +
                        "\n****2. Agregar Cupones *********" +
                        "\n****3. Realizar Ventas ********" +
                        "\n****4. Realizar Reporte ********" +
                        "\n****5. Salir *******************" +
                        "\nIngrese una opción: ");
                opc = scan.nextInt();

                switch (opc) {
                    case 1:
                        n = true;
                        pos = pos + 1;
                        String nombreP;
                        int precioP;
                        do {
                            System.out.println("ingrese nombre producto: ");
                            nombreP = scan.next();
                            if (prod[0][0] == null) {
                                prod[0][0] = nombreP;
                                n = false;
                            } else {
                                for (int i = 0; i < pos - 1; i++) {
                                    if (prod[i][0].contains(nombreP)) {
                                        System.out.println("el producto ya existe!!");
                                        n = true;
                                    } else {
                                        for (int j = 0; j < pos; j++) {
                                            if (prod[j][0] == null) {
                                                prod[j][0] = nombreP;
                                                n = false;
                                            }
                                        }
                                    }
                                }
                            }
                        } while (n);
                        do {
                            System.out.println("ingrese precio producto: ");
                            precioP = scan.nextInt();
                        } while (precioP <= 0);
                        for (int j = 0; j < pos; j++) {
                            if (prod[j][1] == null) {
                                prod[j][1] = String.valueOf(precioP);
                            }
                        }
                        for (int i = 0; i < pos; i++) {
                            for (int j = 0; j < 2; j++) {
                                System.out.print(prod[i][j]);
                            }
                            System.out.println("");
                        }
                        break;
                    case 2:
                        posd = posd + 1;
                        c = true;
                        String nombreC;
                        int precioD;
                        do {
                            System.out.println("ingrese codigo cupón: ");
                            nombreC = scan.next();
                            if (nombreC.length() == 4) {
                                if (desc[0][0] == null) {
                                    desc[0][0] = nombreC;
                                    c = false;
                                } else {
                                    for (int i = 0; i < posd - 1; i++) {
                                        if (desc[i][0].contains(nombreC)) {//verificador del elemento
                                            System.out.println("el producto ya existe!!");
                                            c = true;
                                        } else {
                                            for (int j = 0; j < posd; j++) {
                                                if (desc[j][0] == null) {
                                                    desc[j][0] = nombreC;
                                                    c = false;
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                System.out.println("cantidad de caracteres incorrecta!!");
                            }
                        } while (nombreC.length() != 4 && c != false);
                        for (int i = 0; i < posd; i++) {
                            for (int j = 0; j < desc[i].length; j++) {
                                if (desc[i][0] == null) {
                                    desc[i][0] = nombreC;
                                }
                            }
                        }
                        do {
                            System.out.println("ingrese cantidad descuento: ");
                            precioD = scan.nextInt();
                        } while (precioD <= 0 && precioD > 100);
                        for (int i = 0; i < posd; i++) {
                            for (int j = 0; j < desc[i].length; j++) {
                                if (desc[i][1] == null) {
                                    desc[i][1] = String.valueOf(precioD);
                                }
                            }
                        }
                        break;
                    case 3:
                        int opcv, opc2, opcC, val;
                        boolean sig = true;
                        System.out.println("Ingrese nombre cliente");
                        cliente = scan.next();
                        do {
                            System.out.println("desea agregar nit? 1. si 2.no: ");
                            val = scan.nextInt();
                            if (val == 1) {
                                System.out.println("ingrese el nit: ");
                                nit = String.valueOf(scan.nextInt());
                                sig = false;
                            } else if (val == 2) {
                                nit = "C/F";
                                sig = false;
                            } else {
                                System.out.println("Ingrese una opcion valida");
                            }
                        } while (sig != false);
                        try {
                            do {
                                posv = posv + 1;
                                for (int i = 0; i < pos; i++) {
                                    System.out.print(i + 1);
                                    for (int j = 0; j < prod[i].length; j++) {
                                        if (prod[i][j] != null) {
                                            System.out.print("\t" + prod[i][j]);
                                        }
                                    }
                                    System.out.println("");
                                }
                                System.out.println("que producto se vendera: ");
                                opcv = scan.nextInt();
                                System.out.println("cuantas unidades de " + prod[opcv - 1][0] + " desea llevar: ");
                                opcC = scan.nextInt();
                                for (int i = 0; i < posv; i++) {
                                    for (int j = 0; j < prod[i].length; j++) {
                                        for (int k = 0; k < venta[i].length; k++) {
                                            if (venta[i][k] == null) {
                                                venta[i][j] = prod[opcv - 1][j];
                                                venta[i][2] = String.valueOf(opcC);
                                            }
                                        }
                                    }
                                }
                                subt = subt + (opcC * Integer.parseInt(prod[opcv - 1][1]));
                                System.out.println("total: " + subt);
                                System.out.println("seleccionara otro producto: 1. Si 2. No");
                                opc2 = scan.nextInt();
                            } while (opc2 != 2);
                            System.out.println("Su total es:\t" + subt);
                            System.out.println("cupon de descuento: 1. si 2.no");
                            opc2 = scan.nextInt();
                            if (opc2 == 1) {
                                System.out.println("ingrese su codigo de descuento: ");
                                codD = scan.next();
                                if (codD.length() == 4) {
                                    for (int i = 0; i < posd; i++) {
                                        if (desc[i][0].contains(codD)) {
                                            desOb = Double.parseDouble(desc[i][1]);
                                            System.out.println("codigo valido, su descuento es de: " + desc[i][1] + "%");
                                            total = subt - (subt * (desOb / 100));
                                        } else {
                                            System.out.println("codigo invalido");
                                            total = subt;
                                        }
                                    }
                                } else {
                                    System.out.println("codigo invalido");
                                }

                            }
                        } catch (InputMismatchException e) {
                            System.out.println("ingrese una opcion valida");
                        }
                        System.out.println("Factura");
                        System.out.println("empresa: " + empresa);
                        System.out.println("Cajero que atendio: " + caj);
                        System.out.println("Cliente: " + cliente);
                        System.out.println("Fecha: " + fecha);
                        System.out.println("producto\tprecio\tunidades");
                        for (int i = 0; i < posv; i++) {
                            System.out.print(i + 1);
                            for (int j = 0; j < venta[i].length; j++) {
                                System.out.print("\t" + venta[i][j] + "\t");
                            }
                            System.out.println("");
                        }
                        System.out.println("su sub total es: " + subt);
                        System.out.println("su descuento es: " + desOb + "%");
                        System.out.println("su total es: " + total);
                        break;
                    case 4:
                        for (int i = 0; i < posv; i++) {
                            reporte[i][0] = venta[i][0];
                            reporte[i][1] = venta[i][2];
                        }

                        break;
                    case 5:
                        System.out.println("Adios!");
                        act = false;
                        break;
                    default:
                        System.out.println("ingrese una opcion valida entre el 1-5");
                        break;
                }
            }
            while (act);
        } catch (
                InputMismatchException e) {
            System.out.println("favor de ingresar una opción numerica!!");
            Practica1.Menu();
        }
    }
}