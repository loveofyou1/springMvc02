package sun.entity;

/**
 * @author sunlei19
 * @create 2018-02-23 15:59
 */
public class UserVO {

    private int id;

    private String userName;

    private String password;

    private int age;

    private ContractInfo contractInfo;

    public ContractInfo getContractInfo() {

        return contractInfo;
    }

    public void setContractInfo(ContractInfo contractInfo) {
        this.contractInfo = contractInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", contractInfo=" + contractInfo +
                '}';
    }
}
