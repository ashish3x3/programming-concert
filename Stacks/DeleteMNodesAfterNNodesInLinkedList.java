

public void deleteNafterM(final Node node, final int n, final int m)
{
Node prev = node;
Node current = node;

while (true)
{
int count = 0;
int countN = 0;
if (current == null || current.next == null)
{
return;
}
while (count < m && current != null)
{
prev = current;
current = current.next;
count++;
}
while (countN < n && (prev == null || prev.next != null))
{
System.out.println(prev.key);
prev.next = prev.next.next;
current = prev.next;
countN++;
}

}
}

•
Reply
•
Share ›

