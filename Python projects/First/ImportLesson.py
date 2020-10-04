import re

f = open("input.txt")
text = f.read()
print(re.findall('(.*)"(.*)"', text, flags=2))
