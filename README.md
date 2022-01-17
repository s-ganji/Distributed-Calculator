# Distributed-Calculator
Implementation of a calculator which performs calculations requested by a client on a server with Java programming language, Computer Network course final project, Fall 2018 <br/>
The goal of this project is implementation of a calculater on a server to calculate and send results to  clients' requests via java TCP socket conncetion. <br/>
The format of calculation requests which are sent from client to server should be as follows: <br/>
$ operator $ op1 $ op2 $   <br/>
where operator can be one of the followings:
- Add
- Subtract
- Divide
- Multiply
- Sin
- Cos
- Tan
- Cot<br/>
.<br/>
The format of Calculation responds which are sent from server to client should be as follows: <br/>
$ calculation time $ result $ 
