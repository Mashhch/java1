package com.company;

class MyList {
    private int size = 0;
    MyList.Record head = null;

    class Record {
        private Object data;
        private MyList.Record next = null;
        private MyList.Record prev = null;

        public Record(Object data) {
            this.data = data;
        }
    }

    public MyList() {
    }

    public MyList(Object data) {
        ++this.size;
        this.head = new MyList.Record(data);
    }

    boolean isEmpty() {
        return this.size == 0 && this.head == null;
    }

    void add(Object data) {
        if (this.isEmpty()) {
            this.head = new MyList.Record(data);
        } else {
            MyList.Record findEnd;
            for(findEnd = this.head; findEnd.next != null; findEnd = findEnd.next) {
            }

            findEnd.next = new MyList.Record(data);
            findEnd.next.prev = findEnd;
        }

        ++this.size;
    }

    void add(Object data, int index) {
        MyList.Record findEnd = this.head;
        if (this.isEmpty()) {
            this.head = new MyList.Record(data);
        } else if (index < this.size) {
            if (index <= 0) {
                findEnd.prev = new MyList.Record(data);
                findEnd.prev.next = this.head;
                this.head = findEnd.prev;
            } else {
                while(index > 0) {
                    findEnd = findEnd.next;
                    --index;
                }

                MyList.Record newRecord = new MyList.Record(data);
                newRecord.prev = findEnd.prev;
                findEnd.prev.next = newRecord;
                newRecord.next = findEnd;
                findEnd.prev = newRecord;
            }
        } else {
            while(findEnd.next != null) {
                findEnd = findEnd.next;
            }

            findEnd.next = new MyList.Record(data);
            findEnd.next.prev = findEnd;
        }

        ++this.size;
    }

    int indexOf(Object data) {
        int index = 0;
        if (this.isEmpty()) {
            return -1;
        } else {
            for(MyList.Record findRecord = this.head; findRecord != null; findRecord = findRecord.next) {
                if (findRecord.data == data) {
                    return index;
                }

                ++index;
            }

            return -1;
        }
    }

    boolean contains(Object data) {
        return this.indexOf(data) != -1;
    }

    Object get(int index) {
        MyList.Record findEnd = this.head;
        if (this.isEmpty()) {
            return null;
        } else if (index < 0) {
            return this.head.data;
        } else if (index >= this.size) {
            while(findEnd.next != null) {
                findEnd = findEnd.next;
            }

            return findEnd.data;
        } else {
            while(index > 0) {
                findEnd = findEnd.next;
                --index;
            }

            return findEnd.data;
        }
    }

    Object set(int index, Object newdata) {
        Object olddata = null;
        MyList.Record findEnd = this.head;
        if (this.isEmpty()) {
            this.head = new MyList.Record(newdata);
            return null;
        } else if (index <= 0) {
            olddata = this.head.data;
            this.head.data = newdata;
            return olddata;
        } else if (index >= this.size) {
            while(findEnd.next != null) {
                findEnd = findEnd.next;
            }

            olddata = findEnd.data;
            findEnd.data = newdata;
            return olddata;
        } else {
            while(index > 0) {
                findEnd = findEnd.next;
                --index;
            }

            olddata = findEnd.data;
            findEnd.data = newdata;
            return olddata;
        }
    }

    Object remove(int index) {
        Object oldObject = null;
        MyList.Record findEnd = this.head;
        if (this.isEmpty()) {
            return null;
        } else if (this.size == 1) {
            oldObject = this.head.data;
            this.head = null;
            --this.size;
            return oldObject;
        } else if (index < 0) {
            oldObject = findEnd.data;
            this.head = findEnd.next;
            --this.size;
            findEnd = null;
            return oldObject;
        } else if (index >= this.size) {
            while(findEnd.next != null) {
                findEnd = findEnd.next;
            }

            oldObject = findEnd.data;
            findEnd = null;
            --this.size;
            return oldObject;
        } else if (index == 0) {
            this.head = findEnd.next;
            oldObject = findEnd.data;
            findEnd = null;
            --this.size;
            return oldObject;
        } else {
            while(index > 0) {
                findEnd = findEnd.next;
                --index;
            }

            if (findEnd.next != null) {
                findEnd.next.prev = findEnd.prev;
            }

            if (findEnd.prev != null) {
                findEnd.prev.next = findEnd.next;
            }

            oldObject = findEnd.data;
            findEnd = null;
            --this.size;
            return oldObject;
        }
    }

    int Size() {
        return this.size;
    }

}
