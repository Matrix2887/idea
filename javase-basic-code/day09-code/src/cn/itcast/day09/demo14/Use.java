package cn.itcast.day09.demo14;

public class Use {
        private String name;
        private int money;


        public void show(){
            System.out.println(name + "\t" + "余额:" + money);
        }

    public Use() {
        }

    public Use(String name, int money) {
            this.name = name;
            this.money = money;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }

}
