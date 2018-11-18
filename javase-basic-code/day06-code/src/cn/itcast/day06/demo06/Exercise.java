package cn.itcast.day06.demo06;

public class Exercise {
        private String name ;
        private int age;
        private String job;

        public void watchDog (String ctos){
            System.out.println("艾登皮尔斯是" +  ctos + "的偶像");
        }
        public Exercise() {
        }

        public Exercise(String name, int age, String job) {
            this.name = name;
            this.age = age;
            this.job = job;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


        public int getAge() {
            return age;
        }

        public void setAge(int num) {
        if (num <0){
            System.out.println("年龄以超出芝加哥");
        }else {
            age = num;
        }

        }

        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }

}
