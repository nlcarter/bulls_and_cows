public class Player extends Code {

    public String code;

    @Override
    public String getCode(String msg) {
        System.out.print(msg);
        code = Keyboard.readInput();

        if (code.length() != 4){
            return getCode("Your code must be 4 digits - ");
        } else if (!code.matches("\\d{4}")) {
            return getCode("Your code must only be numeric digits - ");
        } else if (code.charAt(0) == code.charAt(1) || code.charAt(0) == code.charAt(2) || code.charAt(0) == code.charAt(3)
                || code.charAt(1) == code.charAt(2) || code.charAt(1) == code.charAt(3) || code.charAt(2) == code.charAt(3)) {
            return getCode("Your code must have four unique digits - ");
        } else {
            return code.toString();
        }
    }
}
