package src.model;

public class Usuario {
    private int id;
    private String nome;
    private String cpf;
    private String email;
    private String login;
    private String senhaHash;
    private String perfil; // ADMIN, GERENTE, COLABORADOR
    private Integer equipeId;

    // Construtor vazio
    public Usuario() {}

    // Construtor completo
    public Usuario(int id, String nome, String cpf, String email, String login, String senhaHash, String perfil, Integer equipeId) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.login = login;
        this.senhaHash = senhaHash;
        this.perfil = perfil;
        this.equipeId = equipeId;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getSenhaHash() { return senhaHash; }
    public void setSenhaHash(String senhaHash) { this.senhaHash = senhaHash; }

    public String getPerfil() { return perfil; }
    public void setPerfil(String perfil) { this.perfil = perfil; }

    public Integer getEquipeId() { return equipeId; }
    public void setEquipeId(Integer equipeId) { this.equipeId = equipeId; }
}