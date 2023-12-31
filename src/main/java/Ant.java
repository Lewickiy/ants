public class Ant {
    /*
    У нас есть деревянная доска длиной n единиц.
    По доске ходят два муравья, каждый муравей движется со скоростью 1 единица за раунд.
    Один муравей движется влево, другой вправо.
    В одном раунде каждый муравей делает ход. Муравей, идущий влево, движется первым.
    Если муравей собирается переместиться в точку, которая уже занята другим муравьем,
    то каждый из муравьев меняет направление и только после этого движется текущий муравей.
    Предположим, что изменение направления не требует дополнительного раунда.
    Кроме того, муравьи не могут занять одно и то же положение на доске.
    Когда муравей достигает одного конца доски и движется к концу доски, он не выпадает из доски сразу,
    это происходит в следующем раунде.
    Даны целое число n — длина доски и два целых числа:
    left — позиция муравья движущегося влево,
    right — позиция муравья движущегося вправо.
    Возвращает количество раундов, необходимое для того, чтобы первый муравей выпал из доски.

    Ограничения:
    1 <= n <= 10^4
    0 <= left <= n
    0 <= right <= n
    left != right

    Напишите реализацию следующего метода на Java, который, принимает значения n, left, right,
    и возвращает по заданным данным правильный ответ по условию задачи:
     */
    public int calculate(int n, int left, int right) {
        int count = 0;
        if (left > right) {
            while (true) {
                if (left - right != 1) {
                    left--;
                } else {
                    count--;
                    break;
                }
                if (left - right != 1) {
                    right++;
                } else {
                    count--;
                    break;
                }
                count++;
            }
            count = oppositeDirections(n, right, left, count);

        } else if (left < right) {
            count = oppositeDirections(n, right, left, count);
        } else {
            return -1;
        }
        return count;
        }

    private int oppositeDirections(int n, int left, int right, int count) {
        while (true) {
            if (left < 0 || right < 0) {
                break;
            }
            right--;
            if (right > n || left > n) {
                break;
            }
            left++;
            count++;

            }
        return count;
    }
}
