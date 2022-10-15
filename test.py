# 주어진 코드

line = input('Enter two words> ')

words = line.split(' ')
word1 = words[0] # edit this (첫번째 단어)
word2 = words[1] # edit this (두번째 단어))

if word1 > word2:
    print( '{} > {}'.format(word1, word2) )
    
elif word1 < word2:
    print( '{} < {}'.format(word1, word2) )
    
else:
    print( '{} == {}'.format(word1, word2) )