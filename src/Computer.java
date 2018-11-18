public class Computer extends Code {

    @Override
    public String getCode(String msg) {

        //Create four digit code.

        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int digit = (int) (Math.random() * (10));
            code.append(digit);
        }

        //Check that all four digits of code are unique and return code; if not, call getCode() again.

        if (code.charAt(0) == code.charAt(1) || code.charAt(0) == code.charAt(2) || code.charAt(0) == code.charAt(3)
                || code.charAt(1) == code.charAt(2) || code.charAt(1) == code.charAt(3) || code.charAt(2) == code.charAt(3)) {
            return getCode("Code not unique");
        } else {
            return code.toString();
        }

    }
}