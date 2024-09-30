import java.util.Scanner;

/*
* Obtain input
* Parse input, delimiter is ;
* \n is " " and \r is ""
* send input to qe
* */

public class DbCli {
    private static Scanner scanner = new Scanner(System.in).useDelimiter(";");
    private TablePrinter tablePrinter = new TablePrinter();

    private static void cliLoop(IQueryEngine qe) { // method to control the cli inputs from the user
        System.out.print("SQL> ");
        String sql = scanner.next().replace("\n", " ").replace("\r", "").trim();
        TableDto result;

        while (true) {
            if (sql.toLowerCase().startsWith("exit")) {
                break;
            } else if (sql.toLowerCase().startsWith("select")) {
                result = qe.doQuery(sql);
            } else {
                result = qe.doUpdate(sql);
            }
        }

        if (result.message.isEmpty()) {
            tablePrinter.print(result);
        } else {
            System.out.println(result.message);
        }

        scanner.close();
    }
}
