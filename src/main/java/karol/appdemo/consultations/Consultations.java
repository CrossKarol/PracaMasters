package karol.appdemo.consultations;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "consultations")
public class Consultations {


        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "consultations_id")
        private int id;

        @Column(name = "topic")
        @NotNull
        private String topic;

        @Column(name = "description")
        @NotNull
        private String description;

        @Column(name = "date")
        @NotNull
        private String date;

        @Column(name = "hour")
        @NotNull
        private String hour;

        @Column(name = "from_user")
        @NotNull
        private String from_user;

        @Column(name = "to_profesor")
        @NotNull
        private String to_profesor;

        @Column(name = "akceptation")
        @NotNull
        private int akceptation;

        @Column(name = "message_feedback")
        @NotNull
        private String messageFeedback;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getFrom_user() {
        return from_user;
    }

    public void setFrom_user(String from_user) {
        this.from_user = from_user;
    }

    public String getTo_profesor() {
        return to_profesor;
    }

    public void setTo_profesor(String to_profesor) {
        this.to_profesor = to_profesor;
    }

    public int getAkceptation() {
        return akceptation;
    }

    public void setAkceptation(int akceptation) {
        this.akceptation = akceptation;
    }

    public String getMessageFeedback() {
        return messageFeedback;
    }

    public void setMessageFeedback(String messageFeedback) {
        this.messageFeedback = messageFeedback;
    }
}
