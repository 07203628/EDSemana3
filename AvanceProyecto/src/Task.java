package EDSemana3.AvanceProyecto.src;

public class Task {
    private final int id;
    private final String description;
    private final int urgency;
    private final String department;

    public Task(int id, String description, int urgency, String department) {
        this.id = id;
        this.description = description;
        this.urgency = urgency;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getUrgency() {
        return urgency;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return String.format("#%d | Urgencia: %d | Departamento: %s | %s",
                id, urgency, department, description);
    }
}
