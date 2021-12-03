---
layout: essay
type: essay
title: Design Patterns You Didn't Know You Were Using
date: 2021-12-02
labels:
  - Software Engineering
  - Design Patterns
  - Intrests
---
 
Design patterns in software engineering are techniques to solve common problems in software engineering. In software engineering, 
we may face the same type of problem for many different programs that we are trying to create. Luckly, if the problem is common, 
there is likely a well known solution or technique to help you solve the problem. This gives way to common designs that programs 
implement and gives birth to common practices such as the use of subclasses in class based programming. Some of these techniques 
are so common that it is passed off as just a common practice so we may be using someone's design pattern without realizing it. 
<br><br>
Factory Design Pattern
<br>
<img src="https://www.tutorialspoint.com/design_pattern/images/factory_pattern_uml_diagram.jpg">
<br>
I personally have implemented one of the most common design patterns without realizing it, and that is the factory design pattern. 
The factory design pattern is one of the most common ways to use subclasses. In fact, my introduction to design patterns was taught 
with the factory design pattern, however, I was not told that it was called the factory design pattern nor was I told that it was a 
design pattern at all. This design pattern is very useful in programs that need multiple different classes with certain aspects in 
common. The pattern starts with a parent class that defines a vague attribute of the subclasses you want to define. Then, the 
subclasses are created to extend the parent class and define more specific attributes, and inherit the attributes of the parent class. 
It is a simple yet powerful technique that I use quite often and didn't even realize that it is a very common design pattern.
<br>
<img src="https://refactoring.guru/images/refactoring/content/smells/large-class-01.png?id=acac82f25cc90aaa413c">
<br>
Design patterns also give way to anti-design patterns which are design patterns that should not be used. They are best used as examples 
of bad code and things that should not be implemented. In short, anti-design patterns are the best examples of what not to do. One 
antipattern I am guilty of implementing in my early days is known as a god class implementation where you have a single class do too 
much. In my early days of software engineering, I didn't feel like overcomplicating things by involving multiple classes, so I put all 
I needed into one class. This is a bad practice, not only do you not take full advantage of what classes have to offer, but it makes the 
code. I learned the hard way that it is better to simplify each portion of a program by putting them into different classes. It may be a 
little more work creating separate classes, but it makes coding easier in the long run, and improves the readability of any code, making 
fixing bugs a lot less headache inducing.
<br><br>
In essence, design patterns are a standard of implementing code that helps to solve the most common problems in programming in the most 
efficient and effective way currently known in the community. Not only does it help implement programs in the best way, but can also tell 
us what not to implement in order to have a good clean program.
<br>
