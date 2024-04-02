package virtue14.bootproject.dto;

import lombok.Data;

@Data
public class CalculatorDTO {
    private int num1;
    private int num2;
    private int sum;

    public CalculatorDTO(int num1, int num2) {

    }
}
