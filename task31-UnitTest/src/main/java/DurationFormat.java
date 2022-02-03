public class DurationFormat {

        static int inputTime = 31626061; // Ввод времени в секундах
        static int years;
        static int days;
        static int hours;
        static int minutes;
        static int seconds;
        static String time = "";

        public static void main(String[] args) {
            System.out.println(formatDuration(inputTime));
        }

        static String formatDuration(int inputTime) {
            years = inputTime / (60 * 60 * 24 * 365);
            days = inputTime / (60 * 60 * 24) - years * 365;
            hours = inputTime / (60 * 60) - years * 365 * 24 - days * 24;
            minutes = inputTime / 60 - years * 365 * 24 * 60 - days * 24 * 60 - hours * 60;
            seconds = inputTime % 60;
            if (inputTime == 0) {
                return "Now";
            }
            checkYears(years);
            checkDays();
            checkHours();
            checkMinutes();
            checkSeconds();
            return time;
        }

        static String checkYears(int years) {
            if (years > 1) {
                time = years + " years";
                return time;
            } else if (years == 1) {
                time = years + " year";
                return time;
            }
            return time;
        }

        static void checkDays() {
            if (days > 1) {
                if (hours >= 1 || minutes >= 1 || seconds >= 1) {
                    time = time + ", " + days + " days";
                } else {
                    time = time + " and " + days + " days";
                }
            } else if (days == 1) {
                if (hours >= 1 || minutes >= 1 || seconds >= 1) {
                    time = time + ", " + days + " day";
                } else {
                    time = time + " and " + days + " day";
                }
            }
        }

        static void checkHours() {
            if (hours > 1) {
                if (minutes >= 1 || seconds >= 1) {
                    time = time + ", " + hours + " hours";
                } else {
                    time = time + " and " + hours + " hours";
                }
            } else if (hours == 1) {
                if (minutes >= 1 || seconds >= 1) {
                    time = time + ", " + hours + " hour";
                } else {
                    time = time + " and " + hours + " hour";
                }
            }
        }

        static void checkMinutes() {
            if (minutes > 1) {
                if (seconds >= 1) {
                    time = time + ", " + minutes + " minutes";
                } else {
                    time = time + " and " + minutes + " minutes";
                }
            } else if (minutes == 1) {
                if (seconds >= 1) {
                    time = time + ", " + minutes + " minute";
                } else {
                    time = time + " and " + minutes + " minute";
                }
            }
        }

        static  void checkSeconds() {
            if (time == "") {
                if (seconds > 1) {
                    time = seconds + " seconds";
                } else if (seconds == 1) {
                    time = seconds + " second";
                }
            } else if (seconds > 1) {
                time = time + " and " + seconds + " seconds";
            } else if (seconds == 1) {
                time = time + " and " + seconds + " second";
            }
        }
}
