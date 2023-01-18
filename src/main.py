from tkinter import *
from tkinter import messagebox
from string import ascii_uppercase

window = Tk()
window.title("Hangman Game")

photos = [PhotoImage(file="images/hang0.png"), PhotoImage(file="images/hang1.png"), PhotoImage(file="images/hang2.png"),
          PhotoImage(file="images/hang3.png"),PhotoImage(file="images/hang4.png"), PhotoImage(file="images/hang5.png"), PhotoImage(file="images/hang6.png"),
          PhotoImage(file="images/hang7.png"),PhotoImage(file="images/hang8.png"), PhotoImage(file="images/hang9.png"),
          PhotoImage(file="images/hang10.png"), PhotoImage(file="images/hang11.png")]

def jouer():
    messagebox.showinfo("Hangman Game", "You have 11 guesses")
    global mot_avec_espaces
    global suppositions
    suppositions = 0
    imgLabel.config(image=photos[0])
    mot = input("Type the word to guess: ").upper()
    mot_avec_espaces = " ".join(mot)
    lblWord.set(" ".join("_" * len(mot)))

def deviner(letter):
    global suppositions
    if suppositions < 11:
        txt = list(mot_avec_espaces)
        deja_devine = list(lblWord.get())
        if mot_avec_espaces.count(letter) > 0:
            for x in range(len(txt)):
                if txt[x] == letter:
                    deja_devine[x] = letter
                lblWord.set("".join(deja_devine))
                if lblWord.get() == mot_avec_espaces:
                    messagebox.showinfo("Hangman Game", "Bravo! You won!")
                    jouer()
        else:
            suppositions += 1
            imgLabel.config(image=photos[suppositions])
            if suppositions == 11:
                messagebox.showwarning("Hangman", "You lost!")


imgLabel = Label(window)
imgLabel.grid(row=0, column=0, columnspan=3, padx=20, pady=30)
imgLabel.config(image=photos[0])

lblWord = StringVar()
Label(window, textvariable=lblWord, font=("Times 24 bold")).grid(row=0, column=3, columnspan=6, padx=10)
n = 0
for c in ascii_uppercase:
    Button(window, text=c,bg='blue', command=lambda c=c: deviner(c), font=("Times 18"), width=4).grid(row=1 + n // 9,
                                                                                              column=n % 9)
    n += 1

Button(window, text="Rejouer",bg='red', command=lambda: jouer(), font=("Times 10 bold italic")).grid(row=3, column=8,
                                                                                             sticky="NSWE")
jouer()
window.mainloop()