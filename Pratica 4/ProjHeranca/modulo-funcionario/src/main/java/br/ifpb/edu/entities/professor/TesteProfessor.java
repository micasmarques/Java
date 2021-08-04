package br.ifpb.edu.entities.professor;

public class TesteProfessor {
    public static void main(String[] args) {
        Professor professor = new Professor(
                "Novo Professor",
                32,
                "Prof End",
                1100,
                32
        );
        System.out.println(professor + "\n---");

        professor.setNumHoras( 50 );

        System.out.println(professor + "\n");
    }
}
