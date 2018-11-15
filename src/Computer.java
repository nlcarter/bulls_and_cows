public class Computer extends Code {

    @Override
    public String getCode() {

        //Create four digit code.

        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int digit = (int) (Math.random() * (9 - 0));
            code.append(digit);
        }

        //Check that all four digits of code are unique and return code; if not, call getCode() again.

        if (code.charAt(0) == code.charAt(1) || code.charAt(0) == code.charAt(2) || code.charAt(0) == code.charAt(3)
                || code.charAt(1) == code.charAt(2) || code.charAt(1) == code.charAt(3) || code.charAt(2) == code.charAt(3)) {
            return getCode();
        } else {
            return code.toString();
        }
    }
}
