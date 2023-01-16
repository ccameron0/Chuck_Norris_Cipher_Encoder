class Employee {

    String name;
    String email;
    int experience;

    public Employee (String name, String email, int experience) {
        this.name = name;
        this.email = email;
        this.experience = experience;
    }

    public int getExperience() {
        return experience;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}

class Developer extends Employee {
    String mainLanguage;
    String[] skills;

    public Developer (String name, String email, int experience,
                       String mainLanguage, String[] skills) {
        super(name, email, experience);
        this.mainLanguage = mainLanguage;
        this.skills = skills;
    }

    public String getMainLanguage() {
        return mainLanguage;
    }

    public String[] getSkills() {
        return skills;
    }
}

class DataAnalyst extends Employee {

    boolean isPhd;
    String[] methods;

    public DataAnalyst (String name, String email, int experience,
                        boolean isPhd, String[] methods) {
        super(name, email, experience);
        this.isPhd = isPhd;
        this.methods = methods;
    }

    public boolean isPhd() {
        return isPhd;
    }

    public String[] getMethods() {
        return methods;
    }
}