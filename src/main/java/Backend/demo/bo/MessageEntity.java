package Backend.demo.bo;

import javax.persistence.*;
import java.security.PrivateKey;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "message", schema = "server_db")
public class MessageEntity {
    private int id;
    private String title;
    private String content;
    private Timestamp sent;
    private UsersEntity toUser;
    private UsersEntity fromUser;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", nullable = true, length = 45)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "content", nullable = true, length = 45)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "sent", nullable = true)
    public Timestamp getSent() {
        return sent;
    }

    public void setSent(Timestamp sent) {
        this.sent = sent;
    }

    @ManyToOne
    @JoinColumn(name = "toUserId_fk")
    public UsersEntity getToUser() {
        return this.toUser;
    }

    public void setToUser(UsersEntity toUser) {
        this.toUser = toUser;
    }

    @ManyToOne
    @JoinColumn(name = "fromUserId_fk")
    public UsersEntity getFromUser() {
        return this.fromUser;
    }

    public void setFromUser(UsersEntity fromUser) {
        this.fromUser = fromUser;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageEntity that = (MessageEntity) o;
        return id == that.id &&
                Objects.equals(title, that.title) &&
                Objects.equals(content, that.content) &&
                Objects.equals(sent, that.sent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, sent);
    }
}
