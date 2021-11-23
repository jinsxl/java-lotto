package lotto.view;

import java.util.Objects;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_PRICE_MSG = "구입금액을 입력해 주세요.";
    private static final String MINIMUM_PURCHASE_PRICE_MSG = "로또는 1000원 단위로 구매할 수 있습니다.";
    private static final Integer NUMBER_ZERO = 0;
    private static final Integer NUMBER_THOUSAND = 1000;

    private Integer inputPrice;

    public InputView() {

    }

    public InputView(Integer inputPrice) {
        this.inputPrice = inputPrice;
    }

    public void inputPrice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(INPUT_PRICE_MSG);
        inputPrice = Integer.valueOf(scanner.next());
        validateSmallestUnit(inputPrice);
    }

    private void validateSmallestUnit(Integer inputPrice) {
        if (inputPrice < NUMBER_THOUSAND || Math.floorDiv(inputPrice, NUMBER_THOUSAND) != NUMBER_ZERO) {
            System.exit(NUMBER_ZERO);
            throw new IndexOutOfBoundsException(MINIMUM_PURCHASE_PRICE_MSG);
        }
    }

    public Integer getLottoGameCount() {
        return inputPrice / NUMBER_THOUSAND;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputView inputView = (InputView) o;
        return Objects.equals(inputPrice, inputView.inputPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inputPrice);
    }


}
