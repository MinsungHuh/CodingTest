package kr.co.chrisdev.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 제 설명
 * 스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.
 *
 * 예를 들어 스파이가 가진 옷이 아래와 같고 오늘 스파이가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면 다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다.
 *
 * 종류	이름
 * 얼굴	동그란 안경, 검정 선글라스
 * 상의	파란색 티셔츠
 * 하의	청바지
 * 겉옷	긴 코트
 * 스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다.
 * 스파이가 가진 의상의 수는 1개 이상 30개 이하입니다.
 * 같은 이름을 가진 의상은 존재하지 않습니다.
 * clothes의 모든 원소는 문자열로 이루어져 있습니다.
 * 모든 문자열의 길이는 1 이상 20 이하인 자연수이고 알파벳 소문자 또는 '_' 로만 이루어져 있습니다.
 * 스파이는 하루에 최소 한 개의 의상은 입습니다.
 *
 * 입출력 예
 * clothes	return
 * [[yellow_hat, headgear], [blue_sunglasses, eyewear], [green_turban, headgear]]	5
 * [[crow_mask, face], [blue_sunglasses, face], [smoky_makeup, face]]	3
 */

public class Camouflage {
    public static void main(String[] args) {
        String[][] cloths = {
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"},
        };

        int count = camouflage(cloths);
        System.out.println("count : " + count);
    }

    public static int camouflage(String[][] cloths) {
        int answer = 1;

        Map<String, Integer> clothesMap = new HashMap<>(); // 종류 : 갯수

        for (int i = 0; i < cloths.length; i++) {
            // 종류 여부 판단. 같은 종류 일 경우 Value + 1
            clothesMap.put(cloths[i][1], clothesMap.getOrDefault(cloths[i][1], 0)+1);
        }

        // 경우의 수 체크 answer *= (옷 가지수 + 안 입을 경우)
        for (int val : clothesMap.values()){
            answer *= (val+1);
        }

        // 모두 다 안입는 경우는 존재하지 않으므로 -1
        return answer-1;
    }
}
