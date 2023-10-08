package p1;

class Node {
    int valor;
    Node esquerda;
    Node direita;

    Node(int value) {
        this.valor = value;
        direita = null;
        esquerda = null;
    }
}