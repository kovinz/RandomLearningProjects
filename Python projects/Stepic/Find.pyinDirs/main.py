import os
import os.path

ans = set()
for current_dir, dirs, files in os.walk(".\main"):
    for file in files:
        if file[-3:] == ".py":
            ans.add(current_dir)
ans_list = [i[2:] for i in ans]
ans_list.sort()
text = "\n".join(ans_list)
with open("output.txt", "w") as Fout:
    Fout.write(text)
