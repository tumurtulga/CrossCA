/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Linear;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Mirae Yu
 * @author Tumurtulga Batjargal
 */

public class Function {

    private final Double[] set_of_numbers;
    private final Double[] arg_copy; // Java passes arrays by reference; make a copy.
    private final List<Integer> all_factors = new ArrayList<>(); // factors common to our set_of_numbers

    private int index; // index into array common_factors
    private boolean state_check; // variable to keep state
    private int calc_result;

    public Function(List<Double> group) {
        set_of_numbers = new Double[group.size()];
        arg_copy = new Double[group.size()];
        index = 0;

        //iterate through and retrieve members
        for (double number : group) {
            set_of_numbers[index] = number;
            index++;
        }

        Arrays.sort(set_of_numbers, Collections.reverseOrder());

        state_check = false;
        calc_result = 1;
    }

    /**
     * Our function checks 'set_of_numbers'; If it finds a factor common to all
     * for it, it records this factor; then divides 'set_of_numbers' by the
     * common factor found and makes this the new 'set_of_numbers'. It continues
     * recursively until all common factors are found.
     */
    private int findLCMFactors() {
        System.arraycopy(set_of_numbers, 0, arg_copy, 0, set_of_numbers.length);
        Arrays.sort(arg_copy, Collections.reverseOrder());

        while (index <= arg_copy[0]) {
            state_check = false;
            for (int j = 0; j < set_of_numbers.length; j++) {
                if (set_of_numbers[j] != 1 && (set_of_numbers[j] % index) == 0) {
                    set_of_numbers[j] /= index;
                    if (state_check == false) {
                        all_factors.add(index);
                    }
                    state_check = true;
                }
            }
            if (state_check == true) {
                return findLCMFactors();
            }
            index++;
        }

        return 0;
    }

    /**
     * Just calls out and collects the prepared factors.
     *
     * @return - string value;
     */
    public int getLCM() {
        index = 2;
        findLCMFactors();

        //iterate through and retrieve members
        all_factors.stream().forEach((factor) -> {
            calc_result *= factor;
        });

        return calc_result;
    }
}
