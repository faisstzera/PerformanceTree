package p1;

public class BinaryTree {

    Node root;

    private Node adicionarElementoRecursivo(Node atual, int valor){
        if (atual==null){
            return new Node(valor);
        }
        if (valor < atual.valor) {
            atual.esquerda = adicionarElementoRecursivo(atual.esquerda, valor);
        } else if (valor > atual.valor) {
            atual.direita = adicionarElementoRecursivo(atual.direita, valor);
        } else {
            return atual;
        }

        return atual;
    }

    public void add(int valor) {
        root = adicionarElementoRecursivo(root, valor);
    }

    private boolean contemNodeRecursivo(Node atual, int valor) {
        if (atual == null) {
            return false;
        }
        if (valor == atual.valor) {
            return true;
        }
        return valor < atual.valor
                ? contemNodeRecursivo(atual.esquerda, valor)
                : contemNodeRecursivo(atual.direita, valor);
    }

    public boolean contemNode(int valor) {
        return contemNodeRecursivo(root, valor);
    }

    private Node removerRecursivo(Node atual, int valor) {
        if (atual == null) {
            return null;
        }

        if (valor == atual.valor) {
            // Primeiro caso: não existe nó filho
            if (atual.esquerda == null && atual.direita == null) {
                return null;
            }

            // Segundo caso: apenas um nó filho
            if (atual.direita == null) {
                return atual.esquerda;
            }

            if (atual.esquerda == null) {
                return atual.direita;
            }

            // Terceiro caso: 2 nós filhos
            atual.valor = encontrarMenorValor(atual.direita);
            atual.direita = removerRecursivo(atual.direita, atual.valor);
            return atual;
        }

        if (valor < atual.valor) {
            atual.esquerda = removerRecursivo(atual.esquerda, valor);
            return atual;
        }

        atual.direita = removerRecursivo(atual.direita, valor);
        return atual;
    }

    private int encontrarMenorValor(Node root) {
        return root.esquerda == null ? root.valor : encontrarMenorValor(root.esquerda);
    }


    public void remover(int valor) {
        root = removerRecursivo(root, valor);
    }

    public void percorrerEmOrdem(Node root) {
        if (root != null) {
            percorrerEmOrdem(root.esquerda);
            System.out.print(" " + root.valor);
            percorrerEmOrdem(root.direita);
        }
    }

    public void percorrerPreOrdem(Node node) {
        if (node != null) {
            System.out.print(" " + node.valor);
            percorrerPreOrdem(node.esquerda);
            percorrerPreOrdem(node.direita);
        }
    }

    public void percorrerPosOrdem(Node node) {
        if (node != null) {
            percorrerPosOrdem(node.esquerda);
            percorrerPosOrdem(node.direita);
            System.out.print(" " + node.valor);
        }
    }



}

