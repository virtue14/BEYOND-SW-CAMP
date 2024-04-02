package virtue14.bootproject.service;

import org.springframework.stereotype.Service;
import virtue14.bootproject.dto.CalculatorDTO;

@Service
public class CalculatorService {
    public int plus(CalculatorDTO calculatorDTO) {
        return calculatorDTO.getNum1() + calculatorDTO.getNum2();
    }
}
