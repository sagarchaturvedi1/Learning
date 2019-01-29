import sys
import math

def check_prime(n):
    #print(n)
    if n==1:
        print("Not prime")
        return
    if n > 1:
        root_n = math.sqrt(n)
        #print(root_n)
        for i in range(2,int(root_n)+1):
            #print(n, root_n, i, root_n%i)
            if (n%i) == 0:
                print("Not prime")
                return
    print("Prime")


for line in sys.stdin.readlines()[1:]:
    check_prime(int(line.strip()))
