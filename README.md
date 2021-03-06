# Multifaceted-Alphabet-Blocks
Description:
You are constructing a set of N alphabet blocks. The first block has 1 face. The second block has 2 faces, and so on up to the Nth block, which has N faces. Each face contains a letter.

Given a word list, return a set of blocks that can spell every word on the word list, making N as small as possible. A word can be spelled with the blocks if you can take some subset of the blocks, take one face from each block you chose, put them in some order, and spell the word.

Example Input:
1: zero,
2: one,
3: two,
4: three,
5: four,
6: five,
7: six,
8: seven

Example Output
The smallest possible N in this case is N = 5:
1: e,
2: eo,
3: fhs,
4: rvwx,
5: intuz

This output represents five blocks. Block #1 has one face that contains e, block #2 has two faces, e and o, and so on up to block #5, which has the faces i, n, t, u, and z.

For example, four can be formed by using blocks #3, #2, #5, and #4 in order. Note that ten could not be formed from these blocks even though all the letters are there, because the only t and the only n both appear on block #5, and you can only use at most one face from each block.
Challenge input

This list of 10,000 12-letter words.
