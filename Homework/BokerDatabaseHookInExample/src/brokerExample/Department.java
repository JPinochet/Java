package brokerExample;

public class Department
{
    private String name;
    private int id;
    public Department()
    {

    }

    public Department(int id, String name)
    {
        this.id = id;
        this.name = name;
    }
    public void setId(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    public String toString()
    {
        return "\nDepartment Id     : " + getId() +
               "\nDepartment Name   : " + getName();
    }
}
