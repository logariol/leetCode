package IntegerToEnglish;

public class Solution {
    public String one(int num) {
        return switch (num) {
            case 1 -> "One";
            case 2 -> "Two";
            case 3 -> "Three";
            case 4 -> "Four";
            case 5 -> "Five";
            case 6 -> "Six";
            case 7 -> "Seven";
            case 8 -> "Eight";
            case 9 -> "Nine";
            default -> "";
        };
    }

    public String twoLessThan20(int num) {
        return switch (num) {
            case 10 -> "Ten";
            case 11 -> "Eleven";
            case 12 -> "Twelve";
            case 13 -> "Thirteen";
            case 14 -> "Fourteen";
            case 15 -> "Fifteen";
            case 16 -> "Sixteen";
            case 17 -> "Seventeen";
            case 18 -> "Eighteen";
            case 19 -> "Nineteen";
            default -> "";
        };
    }

    public String ten(int num) {
        return switch (num) {
            case 2 -> "Twenty";
            case 3 -> "Thirty";
            case 4 -> "Forty";
            case 5 -> "Fifty";
            case 6 -> "Sixty";
            case 7 -> "Seventy";
            case 8 -> "Eighty";
            case 9 -> "Ninety";
            default -> "";
        };
    }

    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        int billions = num / 1_000_000_000;
        int millions = (num - billions * 1_000_000_000) / 1_000_000;
        int thousands = (num - billions * 1_000_000_000 - millions * 1_000_000) / 1000;

        int rest = num - billions * 1_000_000_000 - millions * 1_000_000 - thousands * 1000;

        StringBuilder result = new StringBuilder();

        if (billions > 0) {
            result.append(getStr(billions)).append(" Billion");
        }
        if (millions > 0) {
            if (result.length() != 0) result.append(" ");
            result.append(getStr(millions)).append(" Million");
        }

        if (thousands > 0) {
            if (result.length() != 0) result.append(" ");
            result.append(getStr(thousands)).append(" Thousand");
        }

        if (rest > 0) {
            if (result.length() != 0) result.append(" ");
            result.append(getStr(rest));
        }

        return result.toString();
    }

    private String getStr(int num) {
        // Hundreds, and dozens

        int hundred = num / 100;
        int rest = num - hundred * 100;

        StringBuilder result = new StringBuilder();

        if (hundred * rest > 0) {
            result.append(one(hundred)).append(" Hundred ").append(two(rest));
        } else if ((hundred == 0) && (rest != 0))
            result.append(two(rest));
        else if ((hundred != 0) && (rest == 0))
            result.append(one(hundred)).append(" Hundred");

        return result.toString();
    }

    private String two(int rest) {
        StringBuilder sb = new StringBuilder();
        if (rest == 0)
            return sb.toString();
        if (rest < 10)
            sb.append(one(rest));
        else if (rest < 20)
            sb.append(twoLessThan20(rest));
        else {
            int dozens = rest / 10;
            int single = rest - 10 * dozens;

            if (single > 0) {
                sb.append(ten(dozens)).append(" ").append(one(single));
            } else sb.append(ten(dozens));
        }

        return sb.toString();
    }


}
