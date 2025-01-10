import java.util.Scanner;

public abstract class Pessoa {
    protected int id;
    protected String nome;
    protected String email;
    protected String senha;

    public Pessoa(int id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && !nome.isEmpty())
            this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null && !email.isEmpty())
            this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if (senha != null && !senha.isEmpty())
            this.senha = senha;
    }

    public abstract boolean autenticar(String email, String senha);

    public void cadastrar(int id, String nome, String email, String senha) {
        setId(id);
        setNome(nome);
        setEmail(email);
        setSenha(senha);
    }

    public void imprimir() {
        System.out.println("Id: " + getId());
        System.out.println("Nome: " + getNome());
        System.out.println("Email: " + getEmail());
    }

    public void entradaDados(Scanner sc) {
        System.out.print("Id: ");
        setId(Integer.parseInt(sc.nextLine()));
        System.out.print("Nome: ");
        setNome(sc.nextLine());
        System.out.print("Email: ");
        setEmail(sc.nextLine());
        System.out.print("Senha: ");
        setSenha(sc.nextLine());
    }
}
