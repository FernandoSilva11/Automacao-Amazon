# language: pt
Funcionalidade: Comprar produto

  # Fluxo de compras no site Amazon
  # Envolve as páginas Home, Resultado da Consulta e Detalhes Paginas
  Esquema do Cenario: Compra a partir de uma busca <pesquisar>
    Dado que acesso o site Amazon.com
    Quando busco por <pesquisar> e presiono Enter
    Entao exibe uma lista de produtos relacionados com <pesquisar>
    Quando escolho <nomeProduto>
    Entao exibe nome <nomeProduto> e o preco de R$<preco>

    Exemplos: Produtos
      | pesquisar                     | nomeProduto                                                             | preco      |
      | "Ar-Condicionado Split Elgin" | "Ar Condicionado Split Elgin Eco Power Wi - Fi 9000 Btus Frio 220v"     | "1.549,00" |
      | "Chapinha"                    | "Prancha, Titanium blue, 35w, Azul, Bivolt, Britânia"                   | "161,73"   |
      | "tablet"                      | "Tablet Multilaser M7 Wi-Fi 1+32GB Quad Core Android 11 Branco - NB356" | "415,00"   |
      | "fones de ouvido"             | "Fone de Ouvido JBL Tune 500 On Ear Preto - JBLT500BLK"                 | "124,00"   |
