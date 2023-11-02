public class Main {
    public static void main(String[] args) {
        Connect connect = new Connect();
        String select = """
                select revisionNumber, productType, locationAdress
                from audit_department;
                """;

        String[][] obj = connect.allSelect(select);

        System.out.println("----------------------------------------------------------");
        System.out.printf("|%-18s|%-18s|%-18s| \n", "Ревизионный номер", "Тип изделия", "Адрес расположения");
        System.out.println("----------------------------------------------------------");

        for (int i = 0; i < obj.length; i++) {
            for (int j = 0; j < obj[0].length; j++) {
                System.out.printf("|%-18s", obj[i][j]);
            }
            System.out.print("| \n");
            System.out.println("----------------------------------------------------------");
        }
    }
}