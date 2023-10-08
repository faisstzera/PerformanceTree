package p1;

public class AVLTree {

    private Node root;

    public void adicionar(int valor) {
        root = inserir(root, valor);
    }

    public void apagar(int valor) {
        root = deletar(root, valor);
    }

    public Node getRoot() {
        return root;
    }

    public Node find(int valor) {
        Node atual = root;
        while (atual != null) {
            if (atual.valor == valor) {
                break;
            }
            atual = atual.valor < valor ? atual.direita : atual.esquerda;
        }
        return atual;
    }


    void atualizarAltura(Node n) {
        n.altura = 1 + Math.max(altura(n.esquerda), altura(n.direita));
    }

    int altura(Node n) {
        return n == null ? -1 : n.altura;
    }

    int getBalance(Node n) {
        return (n == null) ? 0 : altura(n.direita) - altura(n.esquerda);
    }

    Node rotacionarDireita(Node y) {
        Node x = y.esquerda;
        Node z = x.direita;
        x.direita = y;
        y.esquerda = z;
        atualizarAltura(y);
        atualizarAltura(x);
        return x;
    }

    Node rotacionarEsquerda(Node y) {
        Node x = y.direita;
        Node z = x.esquerda;
        x.esquerda = y;
        y.direita = z;
        atualizarAltura(y);
        atualizarAltura(x);
        return x;
    }

    Node rebalancear(Node z) {
        atualizarAltura(z);
        int balance = getBalance(z);
        if (balance > 1) {
            if (altura(z.direita.direita) > altura(z.direita.esquerda)) {
                z = rotacionarEsquerda(z);
            } else {
                z.direita = rotacionarDireita(z.direita);
                z = rotacionarEsquerda(z);
            }
        } else if (balance < -1) {
            if (altura(z.esquerda.esquerda) > altura(z.esquerda.direita))
                z = rotacionarDireita(z);
            else {
                z.esquerda = rotacionarEsquerda(z.esquerda);
                z = rotacionarDireita(z);
            }
        }
        return z;
    }

    Node inserir(Node node, int valor) {
        if (node == null) {
            return new Node(valor);
        } else if (node.valor > valor) {
            node.esquerda = inserir(node.esquerda, valor);
        } else if (node.valor < valor) {
            node.direita = inserir(node.direita, valor);
        } else {
            return node;
        }
        return rebalancear(node);
    }

    private Node filhoMaisaEsquerda(Node node) {
        Node atual = node;
        /* loop down to find the leftmost leaf */
        while (atual.esquerda != null) {
            atual = atual.esquerda;
        }
        return atual;
    }

    Node deletar(Node node, int valor) {
        if (node == null) {
            return node;
        } else if (node.valor > valor) {
            node.esquerda = deletar(node.esquerda, valor);
        } else if (node.valor < valor) {
            node.direita = deletar(node.direita, valor);
        } else {
            if (node.esquerda == null || node.direita == null) {
                node = (node.esquerda == null) ? node.direita : node.esquerda;
            } else {
                Node filhoMaisaEsquerda = filhoMaisaEsquerda(node.direita);
                node.valor = filhoMaisaEsquerda.valor;
                node.direita = deletar(node.direita, node.valor);
            }
        }
        if (node != null) {
            node = rebalancear(node);
        }
        return node;
    }

    Node busca(int valor) {
        Node atual = root;
        while (atual != null) {
            if (atual.valor == valor) {
                break;
            }
            atual = atual.valor < valor ? atual.direita : atual.esquerda;
        }
        return atual;
    }

    public void percorrerEmOrdem() {
        percorrerEmOrdem(root);
    }

    private void percorrerEmOrdem(Node node) {
        if (node != null) {
            percorrerEmOrdem(node.esquerda);
            System.out.print(node.valor + " ");
            percorrerEmOrdem(node.direita);
        }
    }

    public static class Node {
        int valor;
        int altura;
        Node esquerda;
        Node direita;

        Node(int valor) {
            this.valor = valor;
        }

    }
}