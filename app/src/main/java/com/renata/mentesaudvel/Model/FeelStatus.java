package com.renata.mentesaudvel.Model;

public class FeelStatus {
        public String date;
        public String status;

        public FeelStatus() {

        }

        public FeelStatus(String date, String status) {
            this.date = date;
            this.status = status;

        }
        public String getDate() {
            return  date;
        }
        public void setDate(String date) {
            this.date = date;
        }
        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }


}
