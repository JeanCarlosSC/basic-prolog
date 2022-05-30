import random

sud = [[0 for col in range(1, 10)] for row in range(1, 10)]
sud[0][0] = 2


def generarTabla():
    for cont in range(1, random.randint(10, 15)):
        x = random.randint(0, 8)
        y = random.randint(0, 8)

        limite = 0

        while limite < 50:
            num = random.randint(1, 9)
            sud[x][y] = num

            if isValid():
                break
            else:
                sud[x][y] = 0
            limite += 1

def printBoard():
  texto = ""
  for i in range(0, 9):
    for j in range(0,9):
      texto = texto + " " + str(sud[i][j])
      num = int(j%3)
      if num == 2:
        texto = texto + " | "
    linea = int(i%3)
    print(texto)
    if linea == 2:
      print("- - - - - - - - - - - - -  ")
    texto = ""

def solve():
    global sud
    for rows in range(0, 9):
        for colums in range(0, 9):
            if sud[rows][colums] == 0:
                for k in range(1, 10):
                    sud[rows][colums] = k
                    if isValid() and solve():
                        return True
                    sud[rows][colums] = 0
                return False
    return True





def isValid():
    return verifyRows() and verifyColumns() and verifySquares()


def verifySquares():
    global sud
    for cx in range(0, 9):
        for cy in range(0, 9):
            ix = int(cx / 3) * 3
            iy = int(cy / 3) * 3
            for num in range(1, 10):
                contador = 0
                for j in range(iy, iy + 3):
                    for i in range(ix, ix + 3):
                        if sud[i][j] == num:
                            contador += 1
                        if contador > 1:
                            return False
    return True


def verifyColumns():
    global sud
    for j in range(0, 9):
        for num in range(1, 10):
            contador = 0
            for i in range(0, 9):
                if sud[i][j] == num:
                    contador += 1
                if contador > 1:
                    return False
    return True


def verifyRows():
    global sud
    for i in range(0, 9):
        for num in range(1, 10):
            contador = 0
            for j in range(0, 9):
                if sud[i][j] == num:
                    contador += 1
                if contador > 1:
                    return False
    return True

print("Tablero")
print("   ")
generarTabla()

printBoard()

print("Solucion Tablero")
print("   ")
solve()

printBoard()