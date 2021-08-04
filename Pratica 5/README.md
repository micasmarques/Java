# Prática 5 - Respostas

### Questão 1
---
- [x] **a)** &hellip;
- [ ] **b)** *Classes abstratas não precisam ter apenas métodos abstratos.*
- [ ] **c)** *Se uma classe possui pelo menos um método abstrato, ela DEVE ser abstrata.*
- [x] **d)** &hellip;
- [ ] **e)** *Uma classe concreta pode herdar quaisquer (inclusive todos) métodos de uma classe abstrata, e ela não tem que se tornar abstrata por isso.*
- [x] **f)** &hellip;
- [ ] **g)** *Interfaces podem conter métodos não-abstratos.*
- [ ] **h)** *Para criar uma interface utiliza-se a keyword "interface"*
- [ ] **i)** *Para implementar uma interface utiliza-se a keyword "implements"*
- [x] **j)** &hellip;
- [ ] **k)** *Apenas métodos públicos e abstratos.*
- [ ] **l)** *Interfaces também definem um tipo em Java.*
- [ ] **m)** *Herança de tipo pode conter construtores e ser instanciada, ao contrário de herança de implementação, que não pode ser instanciada e nem ter construtores.*
- [x] **n)** &hellip;
- [ ] **o)** *Classes abstratas podem ter construtores.*
- [x] **p)** &hellip;
- [x] **q)** &hellip;
- [ ] **r)** *Apenas os métodos referentes a essa referência poderão ser chamados.*


### Questão 2
---
<p float="left">
  <img src="Questão 2 - Item 1.png" width="425" />
  <img src="Questão 2 - Item 4.png" width="425" /> 
  <img src="Questão 2 - Item 2.png" width="425" />
  <img src="Questão 2 - Item 5.png" width="425" />
  <img src="Questão 2 - Item 3.png" width="425" />
</p>

### Questão 3
---
| Método | Prós | Contras |
| --------- | ----- | -------- |
| `descontarImposto(Funcionario f) {...}` | Os objetos de tipo GerCampus e ProfEfetivo que são os "alvos" do método, conseguiriam utilizar o método. | Não apenas estas classes, mas todas as outras do tipo funcionário poderiam utilizar o método, o que vai contra o objetivo principal. |
| `descontarImposto(Professor p) {...}`   | Objetos ProfHorista conseguiriam utilizar o método. | A outra classe GerCampus não iria conseguir utilizar, já que ela é de um tipo diferente. |
| `descontarImposto(Gerente g) {...}` | Objetos GerCampus conseguiriam utilizar o método. | A outra classe ProfEfetivo não iria conseguir utilizar, já que ela é de um tipo diferente. |
| `descontarImposto(ProfEfetivo pe) {...}` | Objetos ProfHorista conseguiriam utilizar o método. | Apenas objetos ProfHorista conseguiriam utilizar este método. |
| `descontarImposto(GerCampus gc) {...}` | Objetos GerCampus conseguiriam utilizar o método. | Apenas objetos GerCampus conseguiriam utilizar este método. |

> Soluções: Criar uma Interface contendo os métodos específicos e fazer com que as classes do tipo alvejado implementem a Interface que contém o(s) respectivo(s) métodos. <br> Ex.:

```java
public interface maioresSalarios {
	... descontarImposto() {...};
}
```