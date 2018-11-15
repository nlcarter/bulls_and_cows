public class Player extends Code {

    public String code;

    @Override
    public String getCode() {

        System.out.print("Please enter a unique four digit code: ");

        code = Keyboard.readInput();

        if (code.length() != 4){
            System.out.print("Your code must be 4 digits - ");
            return getCode();
        } else if (!code.matches("\\d{4}")) {
            System.out.print("Your code must only be numeric digits - ");
            return getCode();
        } else if (code.charAt(0) == code.charAt(1) || code.charAt(0) == code.charAt(2) || code.charAt(0) == code.charAt(3)
                || code.charAt(1) == code.charAt(2) || code.charAt(1) == code.charAt(3) || code.charAt(2) == code.charAt(3)) {
            System.out.print("Your code must have four unique digits - ");
            return getCode();
        } else {
            return code.toString();
        }
    }
}
