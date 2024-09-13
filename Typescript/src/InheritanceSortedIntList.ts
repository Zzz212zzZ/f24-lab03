import { SortedIntList } from './hidden/SortedIntListLibrary.js'

/**
 * InheritanceSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

class InheritanceSortedIntList extends SortedIntList {
  private totalAdded: number

  constructor () {
    super()
    this.totalAdded = 0
  }

  /**
   * 
   * @param num  The number to be added to the list
   * @returns  True if the number was added successfully
   */
  add (num: number): boolean {
    this.totalAdded++
    return super.add(num)
  }

  /**
   * 
   * @param list The list to be added to the list
   * @returns  True if the list was added successfully
   */
  getTotalAdded (): number {
    return this.totalAdded
  }



}

export { InheritanceSortedIntList }
