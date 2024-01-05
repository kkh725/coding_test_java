//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] bandage = {5, 1, 5};
        int [][] attacks = {{2,10},{9,15},{10,5},{11,5}};
        System.out.println(solution.solution(bandage,30,attacks));
    }
}

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int full_health = health;
        health = health - attacks[0][1]; //첫번째 공격을 받은 체력

        int a=0;
        int non_attacked=0;
//        for (int i=0; i<11;i++){ //i 는 라운드
//           for(int j=0; j<attacks.length;j++){
//               if (i == attacks[j][0]){ //공격받은 라운드라면
//                   health-=attacks[j][1]; //체력이 공격받은만큼 깎임.
//                   non_attacked = 0; //붕대 연속성 0
//               }
//               else if(non_attacked == bandage[0]){ //붕대 연속성이 최대일때 체력 추가회복
//                   health+=bandage[2]+bandage[1];
//                   non_attacked = 0;
//               }
//
//           }
//        health+=bandage[1];
//           non_attacked++;
//        }

        for (int i=attacks[0][0]+1; i<11;i++){

            if(non_attacked == bandage[0]-1){ //붕대 연속성이 최대일때 체력 추가회복
                health+=bandage[2]+bandage[1];
                non_attacked = 0;
            }
            else if(i==attacks[a+1][0]){ //공격받음 i의 시작이 3이기때문에 애초에 시작안하네
                health-=attacks[a][1];
                non_attacked = 0; //붕대 연속성 0
                a++;
            }
            else{
                health+=bandage[1];
                non_attacked+=1;
            }
            if(health>full_health) health=full_health;
        }

        answer = health;
        if (answer<0) answer = -1 ;

        return answer;
    }
}