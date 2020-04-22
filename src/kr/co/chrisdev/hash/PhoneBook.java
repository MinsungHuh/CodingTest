package kr.co.chrisdev.hash;

import java.util.Arrays;

/**
 * 문제 설명
 * 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
 * 전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
 *
 * 구조대 : 119
 * 박준영 : 97 674 223
 * 지영석 : 11 9552 4421
 * 전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때,
 * 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록
 * solution 함수를 작성해주세요.
 *
 * 제한 사항
 * phone_book의 길이는 1 이상 1,000,000 이하입니다.
 * 각 전화번호의 길이는 1 이상 20 이하입니다.
 *
 * 입출력 예제
 * phone_book	return
 * [119, 97674223, 1195524421]	false
 * [123,456,789]	true
 * [12,123,1235,567,88]	false
 */
public class PhoneBook {

    public static void main(String[] args) {
        String[] phone_book = {"123", "456", "789"};

        boolean result = phoneBook(phone_book);
        System.out.println("PhoneBook Result : " + result);
    }

    /**
     * 입력된 배열을 정렬합니다.
     *
     * i번째 값을 기준으로 j부터 입력된 배열 길이만큼 비교하여 indexOf 특성을 이용하여 0인경우 바로 false를 리턴합니다.
     *
     * @param phone_book 입력배열
     * @return Boolean
     */
    public static boolean phoneBook(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length; i++) {
            String phoneNumber = phone_book[i];
            if (phoneNumber.length() < 1 || phoneNumber.length() > 20) {
                continue;
            }

            for (int j = i+1; j < phone_book.length; j++) {
                if (phone_book[j].indexOf(phoneNumber) == 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
